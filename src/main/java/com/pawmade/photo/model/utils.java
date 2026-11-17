package com.pawmade.photo.model;

import com.pawmade.photo.exception.InvalidPhotoException;
import com.pawmade.photo.exception.StorageException;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

public class utils {

    public static ImageType detectType(MultipartFile file) {
        try (var in = file.getInputStream()) {
            return ImageType.detect(in.readNBytes(12))
                    .orElseThrow(() -> new InvalidPhotoException("Only JPEG, PNG or WEBP images are accepted"));
        } catch (IOException e) {
            throw new StorageException("Cannot read uploaded file", e);
        }
    }

    public static int[] readDimensions(MultipartFile file) {
        try (var raw = file.getInputStream(); var in = ImageIO.createImageInputStream(raw)) {
            var readers = ImageIO.getImageReaders(in);
            if (!readers.hasNext()) return null;
            var reader = readers.next();
            try {
                reader.setInput(in);
                return new int[]{reader.getWidth(0), reader.getHeight(0)};
            } finally {
                reader.dispose();
            }
        } catch (IOException e) {
            return null;
        }
    }

}
