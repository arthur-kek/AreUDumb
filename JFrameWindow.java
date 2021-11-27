import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class JFrameWindow {
    
    private final int MIN_X_BUTTON_POSITION = 150;
    private final int MAX_X_BUTTON_POSITION = 200;
    private final int MIN_Y_BUTTON_POSITION = 100;
    private final int MAX_Y_BUTTON_POSITION = 200;

    private int windowWidth;
    private int windowHeight;

    private Font font;

    public JFrame frame;
    public JButton mYesButton;
    public JButton mNoButton;
    public JTextField mTextField;

    Timer timer = new Timer();

    //The constructor will initialize our windows with given in input parameters
    //In this case the parameters are width and height
    JFrameWindow(int width, int height) {
        windowWidth = width;
        windowHeight = height;

        frame = new JFrame();
        mYesButton = new JButton("Yes");
        mNoButton = new JButton("No");
        mTextField = new JTextField("Are u dumb?");
        font = new Font("SansSerif", Font.BOLD, 40);

        setTextField();
        setButtons();
        setFrame();


        //Let's define the actionListeners on the buttons
        mYesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            	mTextField.setBounds(0,100,300,50);	
                mTextField.setText("I knew it! :3");
                mYesButton.setVisible(false);
                mNoButton.setVisible(false);
                startCountDown();
            }
        });

        mNoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int randomX = (int) Math.floor(Math.random()*(MAX_X_BUTTON_POSITION-MIN_X_BUTTON_POSITION+1)+MIN_X_BUTTON_POSITION);
                int randomY = (int) Math.floor(Math.random()*(MAX_Y_BUTTON_POSITION-MIN_Y_BUTTON_POSITION+1)+MIN_Y_BUTTON_POSITION);
                mNoButton.setLocation(randomX, randomY);
            } 
        
        });
    }


    //Let's define the textField
    public void setTextField() {
        mTextField.setBounds(0,50,300,50);	
        mTextField.setFont(font);
        mTextField.setOpaque(false);
        mTextField.setHorizontalAlignment(JLabel.CENTER);
        mTextField.setBorder(BorderFactory.createEmptyBorder());
        mTextField.setFocusable(false);
    }


    //Let's define the buttons
    public void setButtons() {
        mYesButton.setBounds(40,200,70,35);
        mNoButton.setBounds(180,200,70,35);

        mYesButton.setFocusable(false);
        mNoButton.setFocusable(false);
    }


     //Let's define the actual window that will contain textField and buttons
    public void setFrame() {
        frame.getContentPane().add(mTextField);
        frame.add(mNoButton);
        frame.add(mYesButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    //This is a simple timer that lose the application in 3 seconds after clicking on Yes
    public void startCountDown() {
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            frame.dispose();
            }
        }, 3*1000);
    }
}
