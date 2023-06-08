import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The MapConverter class converts a 2D integer array into a PNG image file.
 */
public class MapConverter 
{
    /**
     * The function converts a 2D integer array into a PNG image file with specific colors assigned to
     * different integer values.
     * 
     * @param map a 2D array of integers representing the map data, where each integer corresponds to a
     * specific color in the output image.
     * @param filename a String representing the name and path of the output file where the PNG image
     * will be saved.
     */
    protected void convertToPNG(int[][] map, String filename) 
    {
        int width = map[0].length;
        int height = map.length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //set pixel values based on map data
        for(int y = 0; y < height; y++) 
        {
            for(int x = 0; x < width; x++) 
            {
                int pixel;
                if(map[y][x] == 1) 
                {
                    pixel = 0x999594; //set gray for 1
                }
                else if(map[y][x] == 2) 
                {
                    pixel = 0xFF0000; //set red for 2
                } 
                else 
                {
                    pixel = 0xFFFFFF; //set white for other values
                }
                image.setRGB(x, y, pixel);
            }
        }

        //save the image as PNG using ImageIO
        try 
        {
            File outputFile = new File(filename);
            ImageIO.write(image, "PNG", outputFile);
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }
}
