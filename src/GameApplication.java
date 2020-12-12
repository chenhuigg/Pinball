import constant.Constant;
import domain.Ball;
import domain.GameView;
import domain.Racket;

import java.awt.*;
import java.awt.event.*;

/**
 * 游戏启动类
 */
public class GameApplication {
    Frame frame = new Frame("一颗小球的畅想");
    private Ball ball;
    private Racket racketTop;
    private Racket racketBottom;
    private GameView gameView;
    // 球拍每次点击移动距离
    private int moveLength = Constant.moveLength;

    private void init() {
        ball = new Ball(192, 300);
        racketTop = new Racket(170, 0);
        racketBottom = new Racket(170, 580);
        gameView = new GameView(ball, racketTop, racketBottom);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) { // 关闭窗口
                System.exit(0);
            }
        });

        // 操作键盘
        KeyListener listener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) { // 按左键，球拍左移动
                    racketTop.moveLeft(moveLength);
                    racketBottom.moveLeft(moveLength);
                } else if (keyCode == KeyEvent.VK_RIGHT) { // 按右键，球拍右移动
                    racketTop.moveRight(moveLength);
                    racketBottom.moveRight(moveLength);
                }
            }
        };

        frame.addKeyListener(listener);
        frame.add(gameView);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameApplication().init();
    }

}
