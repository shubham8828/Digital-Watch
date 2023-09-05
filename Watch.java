import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Watch extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeFormat,dayFormat,dateFormat;
    JLabel timeLabel,dayLabel,dateLabel;
    String time,day,date;

    Watch() {
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        add(timeLabel);
        
        dayLabel = new JLabel(); 
        dayLabel.setFont(new Font("Arial",Font.PLAIN,25));
        dayLabel.setForeground(Color.WHITE);
        add(dayLabel);
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial",Font.PLAIN,20));
        dateLabel.setForeground(Color.red);
        add(dateLabel);
             
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Digital Clock");
        setLayout(new FlowLayout());
        setSize(400, 300);
        setLocation(800,50);
        setVisible(true);
        getContentPane().setBackground(Color.black);
        setResizable(false);
        

        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
    	new Watch();
    }
}
