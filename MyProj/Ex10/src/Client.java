// Client.java

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}

class LoginFrame extends JFrame {
    private JTextField ipField, portField, usernameField;

    public LoginFrame() {
        setTitle("登录聊天室");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(4, 1));
        ipField = new JTextField("127.0.0.1");
        portField = new JTextField("8080");
        usernameField = new JTextField();
        JButton loginButton = new JButton("登录");
        
        panel.add(new JLabel("服务器IP:"));
        panel.add(ipField);
        panel.add(new JLabel("端口:"));
        panel.add(portField);
        panel.add(new JLabel("用户名:"));
        panel.add(usernameField);
        panel.add(loginButton);
        
        loginButton.addActionListener(e -> connectToServer());
        add(panel);
        setVisible(true);
    }

    private void connectToServer() {
        try {
            String ip = ipField.getText();
            int port = Integer.parseInt(portField.getText());
            String username = usernameField.getText();
            Socket socket = new Socket(ip, port);
            
            // 发送用户名
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(username);
            
            new ChatFrame(socket, username);
            dispose(); // 关闭登录窗口
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "连接失败: " + e.getMessage());
        }
    }
}

class ChatFrame extends JFrame {
    private JTextArea chatArea;
    private JList<String> userList;
    private DefaultListModel<String> listModel;

    public ChatFrame(Socket socket, String username) {
        setTitle("聊天室 - " + username);
        setSize(600, 400);
        
        // 界面布局
        JPanel panel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        listModel = new DefaultListModel<>();
        userList = new JList<>(listModel);
        
        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("发送");
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        
        panel.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        panel.add(new JScrollPane(userList), BorderLayout.EAST);
        panel.add(inputPanel, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);
        
        // 消息发送
        sendButton.addActionListener(e -> {
            String message = inputField.getText();
            if (!message.isEmpty()) {
                try {
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println(message);
                    inputField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "发送失败");
                }
            }
        });
        
        // 消息接收线程
        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.startsWith("[USERLIST]")) {
                        updateUserList(message.substring(10));
                    } else {
                        chatArea.append(message + "\n");
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "与服务器断开连接");
                System.exit(0);
            }
        }).start();
    }

    private void updateUserList(String users) {
        SwingUtilities.invokeLater(() -> {
            listModel.clear();
            for (String user : users.split(",")) {
                listModel.addElement(user);
            }
        });
    }
}