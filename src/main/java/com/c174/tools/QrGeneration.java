package com.c174.tools;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QrGeneration {

    private static String charset = "UTF-8";

    /**
     *
     * @param path
     * @param height
     * @param width
     * @return if exist file
     * @throws IOException
     * @throws WriterException
     *
     *
     * Este metodo crea un codigo qr en formato .png
     * a apartir de un path ( uri ) y 2 medidas de tamaño
     * alto y ancho
     */
    public static Boolean generateQr(String path,
                                    int height, int width)
            throws IOException, WriterException {

        UUID uuid = UUID.randomUUID();
        String chain = uuid.toString();

        Map<EncodeHintType, ErrorCorrectionLevel> map = new HashMap<>();

        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(chain.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);

        MatrixToImageWriter.writeToFile(
                matrix,
                path.substring(path.lastIndexOf(".")+1),
                new File(path)
        );

        return Files.exists(Path.of(path));
    }

    /**
     *
     * @param image
     * @return qr
     *
     * Este metodo se encarga de tomar el archivo
     * creado previamente y retornarlo en forma de
     * MultiparFile
     */
    public static String takeQr(String image) throws IOException {

        Path path = Path.of(image);
        File file = new File(image);
        byte[] fileContent = Files.readAllBytes(path);
        String originalFilename = path.getFileName().toString();
        String contentType = Files.probeContentType(path);
        String finalFileString = Base64.getEncoder().encodeToString(fileContent);

        return finalFileString;

    }

    /**
     * @param image
     * @return if the archive can be delete
     *
     * Este metodo intenta borrar un archivo mediante un path
     * si lo logra retorna verdadedora de lo contrario
     * retorna falso
     */
    public static Boolean deleteQr(String image) throws URISyntaxException {

        File file = new File(image);

        if (file.exists()){
            System.out.println("el archivo existe");
            if (file.delete()){
                return true;
            }
            return false;
        }
        System.out.println("el archivo no existe");
        return false;
    }

    @Scheduled(fixedRate = 10000)
    public void regeneratQr(){
        System.out.println("esta andando esto de ejecutar cada cierto tiempo");
    }

}
