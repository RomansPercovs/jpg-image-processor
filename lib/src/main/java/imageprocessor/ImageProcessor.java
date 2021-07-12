package imageprocessor;

import imageprocessor.exception.FaultInputImageException;

import java.io.IOException;

public interface ImageProcessor {
    byte[] reduceDimensionByHeight(byte[] imageBytes, int height) throws IOException, FaultInputImageException;
    byte[] packImageToVolume(byte[] imageBytes, int fileSize) throws IOException, FaultInputImageException;
}
