# 📒狂神说Java 笔记

## 捕获异常

```java
        int a = 1;
        int b = 0;
        try {
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("发现异常：" + e.toString());
        } catch (Throwable throwable) {
            System.out.println("捕获Throwable：" + throwable.toString() );
        } finally {
            System.out.println("finally");
        }

```

## 抛出异常

### 主动抛出异常`throw`

```java
        if (b == 0) {
            throw new ArithmeticException();
        }
```

### 让调用方法的去处理该异常`throws`

```java
    public void testExection(int a, int b) throws ArithmeticException {

    }
```



## 自定义异常

```java
public class MyException extends Exception {

    private int detail;

    public MyException(int detail) {
        super(detail + "");
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
```

使用：

```java
    public void testMyException(int a) throws MyException {
        if (a > 10) {
            throw  new MyException(a);
        }
        System.out.println("OK");
    }
```

```java
    public static void main(String[] args) {
        try {
            new TestException().testMyException(91);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
```



