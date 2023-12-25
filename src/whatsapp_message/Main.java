package whatsapp_message;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import whatsapp_message.message.ImageMessage;
import whatsapp_message.message.TextMessage;

public class Main {
    public static void main(String[] args) {
        // In real world, these functions will be called from your REST API server
        // methods.
        // Don't worry about them for now - let's live in a simple world :)

        // Fazil Bhat sends a text message to Meer Mehtaab
        TextMessage message1 = new TextMessage();
        message1.setSenderId("Fazil Bhat");
        message1.setReceiverId("Meer Mehtaab");
        message1.setTextMessageContent("Hello, Have you checked out my new blog?");
        AndroidHandler.sendText(message1);

        // Aafaan sends a message to Meera
        ImageMessage message2 = new ImageMessage();
        message2.setSenderId("Aafaan");
        message2.setReceiverId("Meera");

        String imagePath = getFilePathFromResource("myBlogPhoto.png");
        message2.setImageMessageContent(imageToBase64StringConversion(imagePath), "1080x1920",
                "Some Random Image MetaData");
        AndroidHandler.sendImage(message2);
    }

    public static String imageToBase64StringConversion(String filePath) {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static String getFilePathFromResource(String fileName) {
        return Main.class.getClassLoader().getResource(fileName).getPath();

    }
}
