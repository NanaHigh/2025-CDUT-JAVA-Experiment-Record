package Ex3.Depends;

/// 复数类
public class Complex {
    float real, imag;

    /// 无参构造方法
    public Complex() {
        this.real = 0;
        this.imag = 0;
    }

    /// 带参构造方法
    public Complex(float real, float imag) {
        this.real = real;
        this.imag = imag;
    }

    /// 实部相加
    public Complex Add(float real) {
        return new Complex(this.real + real, this.imag);
    }

    /// 复数相加
    public Complex Add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    /// 实部相减
    public Complex Sub(float real) {
        return new Complex(this.real - real, this.imag);
    }

    /// 复数相减
    public Complex Sub(Complex c) {
        return new Complex(this.real - c.real, this.imag - c.imag);
    }

    /// 乘以一个实数
    public Complex Mul(float real) {
        return new Complex(this.real * real, this.imag * real);
    }

    /// 乘以一个复数
    public Complex Mul(Complex c) {
        return new Complex(this.real * c.real - this.imag * c.imag, this.real * c.imag + this.imag * c.real);
    }

    /// 转换复数打印格式
    public String toString() {
        if (this.imag >= 0) {
            return this.real + " + " + this.imag + "i";
        } else {
            return this.real + " - " + (-this.imag) + "i";
        }
    }
}
