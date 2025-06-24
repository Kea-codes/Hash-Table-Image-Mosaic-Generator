import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
//Correctness 10 marks ***********************************************
public class Main {
	
	public static void main(String[] args) {
		// Create the mosaic builder
        ImageMosaicBuilder builder = new ImageMosaicBuilder();
        
        try {

	        // Load the tile sheet image (e.g., a grid of tiles)
	        BufferedImage tileSheet = ImageIO.read(new File("tilesheet_pastel.png"));
	        int patchSize = 32; // size of each tile (must match tile sheet dimensions)
	
	        // Extract patches from the tile sheet and build the lookup table
	        builder.buildTileMapFromSheet(tileSheet, patchSize);
	
	        // Load the target image to mosaic
	        BufferedImage targetImage = ImageIO.read(new File("target.png"));
	
	        // Reconstruct the image as a mosaic
	        BufferedImage mosaic = builder.reconstruct(targetImage, patchSize);
	
	        // Save the output mosaic image
	        File outputFile = new File("mosaic_output.png");
	        ImageIO.write(mosaic, "jpg", outputFile);
	
	        System.out.println("Mosaic created and saved to mosaic_output.jpg");
        }
        catch(IOException io) {
        	System.err.println("We encountered an error while creating your moasaic");
        }
		
	}
}
