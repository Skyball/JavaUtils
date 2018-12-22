
/**
 * 图片相关工具类
 */
public class ImageUtils {

    /**
     * 获取本地图片尺寸（宽度、高度）
     * 
     * @throws IOException
     */
    public void getLocalImageSize() throws IOException {
        File picture = new File("C:/Users/XXX/1.jpg");
        BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
        System.out.println(String.format("%.1f", picture.length() / 1024.0));// 源图大小
        System.out.println(sourceImg.getWidth()); // 源图宽度
        System.out.println(sourceImg.getHeight()); // 源图高度

    }

    /**
     * 获取服务器图片的尺寸（宽度、高度）
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void getInternetImageSize() throws FileNotFoundException, IOException {

        //方法一
        URL url = new URL(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545393348697&di=14391133dc0fbe381e4c7b596192eecc&imgtype=0&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20131203%2F20131203162741-1391713842.jpg");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        BufferedImage image = ImageIO.read(connection.getInputStream());
        int srcWidth = image.getWidth(); // 源图宽度
        int srcHeight = image.getHeight(); // 源图高度

        System.out.println("Width = " + srcWidth);
        System.out.println("Height = " + srcHeight);

        //方法二，简写
        InputStream murl = new URL(
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545393348697&di=14391133dc0fbe381e4c7b596192eecc&imgtype=0&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20131203%2F20131203162741-1391713842.jpg")
                        .openStream();
        BufferedImage sourceImg = ImageIO.read(murl);
        System.out.println(sourceImg.getWidth()); // 源图宽度
        System.out.println(sourceImg.getHeight()); // 源图高度

    }

}