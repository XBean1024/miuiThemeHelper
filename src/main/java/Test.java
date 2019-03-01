import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by binny on February
 * function： 修改、更新用户信息
 */
public class Test {
    private JTextPane asdadaasdaTextPane;

    private Frame f = new Frame("小米主题设计师辅助工具");


    private Button[] buttons = new Button[10];

    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    private void init() {
        for (int i = 0; i < 10; i++) {
            buttons[i] = new Button("按钮 " + i);
        }
        f.setLayout(gbl);
        f.addWindowListener(new WinClosing());

        //纵横方向同时扩展
        gbc.fill = GridBagConstraints.BOTH;
        //水平占比
        gbc.weightx = 1;
        addBtn(buttons[0]);
        addBtn(buttons[1]);
        addBtn(buttons[2]);

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addBtn(buttons[3]);

        gbc.gridwidth = 0;
        addBtn(buttons[4]);

        gbc.gridwidth = 2;
        addBtn(buttons[5]);

        gbc.weightx = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addBtn(buttons[6]);

        gbc.gridwidth = 1;
        gbc.gridheight = 2;

        gbc.weighty = 1;
        addBtn(buttons[7]);

        gbc.weighty = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        addBtn(buttons[8]);
        addBtn(buttons[9]);

        f.pack();
        f.setVisible(true);
    }

    private void addBtn(Button button) {
//        button.setLabel("ssss");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        });
        gbl.setConstraints(button, gbc);
        f.add(button);
    }

    public static void main(String[] args) {
        new Test().init();
    }

    class WinClosing extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            super.windowClosing(e);
            System.exit(0);
        }
    }
}
