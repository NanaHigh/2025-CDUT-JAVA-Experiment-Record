// Server.java

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server extends JFrame {
    private JTextArea logArea;
    private JList<String> userList;
    private DefaultListModel<String> listModel;
    private ServerSocket serverSocket;
    private static ConcurrentHashMap<String, PrintWriter> onlineUsers = new ConcurrentHashMap<>();

    public Server() {
        setTitle("聊天室服务器");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 界面组件
        JPanel panel = new JPanel(new BorderLayout());
        logArea = new JTextArea();
        logArea.setEditable(false);
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        
        JPanel inputPanel = new JPanel();
        JTextField portField = new JTextField("8080", 10);
        JTextField maxUsersField = new JTextField("10", 5);
        JButton startButton = new JButton("启动服务器");
        
        inputPanel.add(new JLabel("端口:"));
        inputPanel.add(portField);
        inputPanel.add(new JLabel("最大人数:"));
        inputPanel.add(maxUsersField);
        inputPanel.add(startButton);
        
        panel.add(new JScrollPane(logArea), BorderLayout.CENTER);
        panel.add(new JScrollPane(userList), BorderLayout.EAST);
        panel.add(inputPanel, BorderLayout.NORTH);
        add(panel);

        startButton.addActionListener(e -> {
            int port = Integer.parseInt(portField.getText());
            int maxUsers = Integer.parseInt(maxUsersField.getText());
            startServer(port, maxUsers);
        });
    }

    private void startServer(int port, int maxUsers) {
        try {
            serverSocket = new ServerSocket(port);
            log("服务器已启动，端口: " + port);
            
            new Thread(() -> {
                while (!serverSocket.isClosed()) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        new Thread(new ClientHandler(clientSocket)).start();
                    } catch (IOException e) {
                        log("服务器已关闭");
                    }
                }
            }).start();
        } catch (IOException e) {
            log("端口绑定失败: " + e.getMessage());
        }
    }

    public static void broadcast(String message) {
        for (PrintWriter writer : onlineUsers.values()) {
            writer.println(message);
        }
    }

    private void log(String message) {
        SwingUtilities.invokeLater(() -> logArea.append(message + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Server().setVisible(true));
    }

    class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                
                // 获取用户名
                username = reader.readLine();
                onlineUsers.put(username, writer);
                listModel.addElement(username);
                log(username + " 加入聊天室");
                broadcast(username + " 加入了聊天室");
                
                // 持续接收消息
                String message;
                while ((message = reader.readLine()) != null) {
                    broadcast(username + ": " + message);
                    log(username + ": " + message);
                }
            } catch (IOException e) {
                // 用户断开连接
            } finally {
                try {
                    onlineUsers.remove(username);
                    listModel.removeElement(username);
                    log(username + " 离开了聊天室");
                    broadcast(username + " 离开了聊天室");
                    socket.close();
                } catch (IOException ignored) {}
            }
        }
    }
}