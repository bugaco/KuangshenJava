package com.bugaco.snake;

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {

        // 1.绘制一个静态窗口 JFrame
        JFrame jFrame = new JFrame("BugaCo贪吃蛇小游戏");
        jFrame.setBounds(10, 10, 900, 720); // 设置界面的大小
        jFrame.setResizable(false); // 窗口大小不可改变
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭事件

        // 2.面板JPanel 可以加入到JFrame
        jFrame.add(new GamePanel());

        jFrame.setVisible(true);
    }
}
