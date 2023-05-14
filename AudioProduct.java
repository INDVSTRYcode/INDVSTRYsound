import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 * @author NotMeLOLFuck
 * @version 1.0
 * creates audio extension for product class
 */
public class AudioProduct extends Product{

    //creates class and various instance

    private Long currentFrame;
    private Clip audio;
    private String audioFilePath;
    private String status;
    private AudioInputStream audioInputStream;
    private int c;


    public AudioProduct(String name, double price, String imageFilePath, String audioFilePath)
    throws UnsupportedAudioFileException,
    IOException, LineUnavailableException {

        super(name, price, imageFilePath);
        this.audioFilePath = audioFilePath;

        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath).getAbsoluteFile());
          
        // create clip reference
        audio = AudioSystem.getClip();
          
        // open audioInputStream to the clip
        audio.open(audioInputStream);
          
        audio.loop(Clip.LOOP_CONTINUOUSLY);

        this.stop();
        
    }

    /**
     * code for displaying image and playing audio
     */
    @Override
    public void preview(){

        var frame = new JFrame();
        var icon = new ImageIcon(this.imageFilePath);
        var label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try
        {
            this.restart();
              
            while (true){

                c = Store.getChoice();
                Store.gotoChoice(c, this);
                if (c == 4) {

                break;

                }

            }

        } 
          
        catch (Exception ex){
            System.out.println("Error playing sound.");
            ex.printStackTrace();
          
          }

    }
      
    // Method to play the audio
    public void play()throws IOException, LineUnavailableException,
    UnsupportedAudioFileException
    {
        //start the clip
        audio.start();
          
        status = "play";
    }
      
    // Method to pause the audio
    public void pause() 
    {
        if (status.equals("paused")) 
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = 
        this.audio.getMicrosecondPosition();
        audio.stop();
        status = "paused";
    }
      
    // Method to resume the audio
    public void resumeAudio() throws UnsupportedAudioFileException,
                                IOException, LineUnavailableException 
    {
        if (status.equals("play")) 
        {
            System.out.println("Audio is already "+
            "being played");
            return;
        }
        audio.close();
        resetAudioStream();
        audio.setMicrosecondPosition(currentFrame);
        this.play();
    }
      
    // Method to restart the audio
    public void restart() throws IOException, LineUnavailableException,
                                            UnsupportedAudioFileException 
    {
        audio.stop();
        audio.close();
        resetAudioStream();
        currentFrame = 0L;
        audio.setMicrosecondPosition(0);
        this.play();
    }
      
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
    IOException, LineUnavailableException 
    {
        currentFrame = 0L;
        audio.stop();
        audio.close();
    }
      
    // Method to jump over a specific part
    public void jump(long c) throws UnsupportedAudioFileException, IOException,
                                                        LineUnavailableException 
    {
        if (c > 0 && c < audio.getMicrosecondLength()) 
        {
            audio.stop();
            audio.close();
            resetAudioStream();
            currentFrame = c;
            audio.setMicrosecondPosition(c);
            this.play();
        }
    }
      
    // Method to reset audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
                                            LineUnavailableException 
    {
        audioInputStream = AudioSystem.getAudioInputStream(
        new File(audioFilePath).getAbsoluteFile());
        audio.open(audioInputStream);
        audio.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public Clip getClip(){

        return audio;

    }
}
  
