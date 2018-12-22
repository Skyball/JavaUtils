/**
 * 解压缩文件工具类
 */
public class DecompressUtils {

    /**
     * 压缩文件，并读取压缩文件的输入流
     * 
     * @param path
     * @return
     */
    private InputStream compress(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(path.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    /**
     * 压缩文件到ZipOutputStream流
     * @param file
     * @param zos
     * @param baseDir
     */
    private static void compressFile(File file, ZipOutputStream zos, String baseDir) {
        if (!file.exists())
            return;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(baseDir + file.getName());
            zos.putNextEntry(entry);
            int count;
            byte[] buf = new byte[BUFSIZE];
            while ((count = bis.read(buf)) != -1) {
                zos.write(buf, 0, count);
            }
            bis.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}