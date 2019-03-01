package values.msm;

import utils.ScreenSizeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static utils.LogUtil.logStr;

/**
 * Created by binny on March
 * function： 修改、更新用户信息
 */
public class MsgColor {
    private String msmName[] = new String[]{
            "短信标题",
//            "短信标题",
//            "短信标题",
//            "短信标题",
//            "短信标题",
//            "短信标题",
//            "短信标题",
//            "短信标题",
//            "短信标题",
            "短信列表中主要字体颜色"
    };
    private JFrame msmContainer = new JFrame("短信属性");
    private JList propertyList = new JList(msmName);

    public void init() {
        propertyList.setCellRenderer(new ButtonRenderer());
        propertyList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                // 获取所有被选中的选项索引
                int[] indices = propertyList.getSelectedIndices();
                logStr(indices.length);
                // 获取选项数据的 ListModel
                ListModel<String> listModel = propertyList.getModel();
                // 输出选中的选项
                for (int index : indices) {
                    logStr("选中: " + index + " = " + listModel.getElementAt(index));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
        msmContainer.add(propertyList);
        msmContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logStr("ScreenSizeUtil.getScreenWidth() : "+ScreenSizeUtil.getScreenWidth());
        logStr("ScreenSizeUtil.getScreenHeight() : "+ScreenSizeUtil.getScreenHeight());
        msmContainer.setBounds(1280, 0, 1000, 800);
        msmContainer.setVisible(true);
    }

    class ButtonRenderer extends JPanel implements ListCellRenderer {

        private Color foreground;//字体颜色
        private Color background;
        private String name;
        private Color chooseColorForeground = Color.green;
        private Color unChooseColorForeground = Color.magenta;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            background = isSelected ? Color.CYAN : Color.RED;
            foreground = isSelected ? chooseColorForeground : unChooseColorForeground;
            name = value.toString();
//            System.out.println(index);

            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            int width = 50;
            int height = 50;
            g.setColor(Color.red);
//            g.fillRoundRect(0, 0, width, height, 2, 2);
            Font font = new Font("楷体", Font.BOLD, 40); // 创建字体对象
            g.setFont(font);
            g.setColor(foreground);
            g.drawString(name, 50, 50);
            g.drawRoundRect(10,10,800,100,10,10);
        }
    }

    public static void main(String[] args) {
        new MsgColor().init();
    }
}
