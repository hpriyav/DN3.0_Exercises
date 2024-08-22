
interface Image {
    void display();
}


class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}


class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}


public class ImageViewerTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        System.out.println("First call to display image1:");
        image1.display(); // Loads and displays image1

        System.out.println("\nSecond call to display image1:");
        image1.display(); // Only displays image1

        System.out.println("\nFirst call to display image2:");
        image2.display(); // Loads and displays image2

        System.out.println("\nSecond call to display image2:");
        image2.display(); // Only displays image2
    }
}