package imageprocessor;

import imageprocessor.exception.FaultInputImageException;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageProcessorImpl implements ImageProcessor {

    @Override
    public byte[] reduceDimensionByHeight(byte[] imageBytes, int height) throws IOException {
        if(imageBytes != null && imageBytes.length > 0) {
            byte[] encodedImage = Base64.getDecoder().decode(imageBytes);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(encodedImage));
            image = Scalr.resize(image, image.getWidth(), height);
            ByteArrayOutputStream outImage = new ByteArrayOutputStream();
            ImageIO.write(image, "JPEG", outImage);
            return Base64.getEncoder().encode(outImage.toByteArray());
        } else {
            throw new FaultInputImageException("Corrupted image");
        }
    }

    @Override
    public byte[] packImageToVolume(byte[] imageBytes, int fileSize) throws IOException {
        if(imageBytes != null && imageBytes.length > 0) {
            byte[] encodedImage = Base64.getDecoder().decode(imageBytes);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(encodedImage));
            image = Scalr.resize(image, fileSize);
            ByteArrayOutputStream outImage = new ByteArrayOutputStream();
            ImageIO.write(image, "JPEG", outImage);
            return Base64.getEncoder().encode(outImage.toByteArray());
        } else {
            throw new FaultInputImageException("Corrupted image");
        }
    }
}
