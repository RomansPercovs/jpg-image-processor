//package imageprocessor;
//
//import imageprocessor.exception.FaultInputImageException;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.util.Base64;
//
//public class ImageProcessorTest {
//
//    @Rule
//    ExpectedException exception = ExpectedException.none();
//
//    @Test
//    public void reduceDimensionByHeight_wrongInputFile() throws Exception {
//        ImageProcessor imageProcessor = new ImageProcessorImpl();
//        exception.expect(FaultInputImageException.class);
//        exception.expectMessage("Corrupted image");
//        imageProcessor.reduceDimensionByHeight(null, 100);
//    }
//
//    @Test
//    public void reduceDimensionByHeight() throws IOException {
//        ImageProcessor imageProcessor = new ImageProcessorImpl();
//        byte[] image = downloadUrl(new URL("https://res.cloudinary.com/demo/image/upload/q_90/happy_dog.jpg"));
//        byte[] reducedImage = imageProcessor.reduceDimensionByHeight(image, 2500);
//        try(FileOutputStream stream = new FileOutputStream("C:\\Users\\Romans\\Desktop\\doggo.jpg")) {
//            stream.write(reducedImage);
//        }
//    }
//
//    // helper methods
//
//    private byte[] downloadUrl(URL toDownload) {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        try {
//            byte[] chunk = new byte[4096];
//            int bytesRead;
//            InputStream stream = toDownload.openStream();
//
//            while ((bytesRead = stream.read(chunk)) > 0) {
//                outputStream.write(chunk, 0, bytesRead);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return Base64.getEncoder().encode(outputStream.toByteArray());
//    }
//}
