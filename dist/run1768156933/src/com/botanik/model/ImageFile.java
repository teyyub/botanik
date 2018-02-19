package com.botanik.model;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import javafx.scene.image.Image;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author teyyub , Feb 9, 2018 , 4:17:35 PM
 */
public class ImageFile {

    private Number id;
    private String path;
    private File selectedFile;
    private File destinationFile;
    private Image selectedImage;
    private String fileName;
    private String fileExtention;

    public ImageFile() {
    }

    public ImageFile(String file) {
        this.path = file;
    }

    public String content() {

        return "";
    }

    public File selectedFile(File file) {

        return this.selectedFile = file;

    }

    public Image image(File selectedFile) throws MalformedURLException {
        if (selectedFile == null) {
            this.selectedFile = null;
            return null;
        } 
        this.selectedFile = selectedFile;
        return new Image(selectedFile.toURI().toURL().toString());
    }

//    if (imageFile.selectedFile(fileChooser.showOpenDialog(dialogStage))!=null){
//            System.out.println("file original name " + selectedFile.getName());
//            System.out.println("file ext " + FilenameUtils.getExtension(selectedFile.getName()));
//            System.out.println("file name " + FilenameUtils.getBaseName(selectedFile.getName()));
//            file_ext = FilenameUtils.getExtension(selectedFile.getName());
//            
//            imageView.setImage(selectedImage);
//            Long id = System.currentTimeMillis();
//            destinationFile = new File("C:/Botanika/images/" + id + "." + file_ext);
//            Files.copy(selectedFile.toPath(), destinationFile.toPath());
//        }
}
