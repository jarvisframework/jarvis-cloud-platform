package com.jarvis.platform.autoconfigure.license.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Doug Wang
 * @since 1.8, 2024-04-16 10:43:35
 */
public class LicenceUtil {
    private static final Logger log = LoggerFactory.getLogger(LicenceUtil.class);
    private static String directory = null;
    private static String filename = "lic.licence";
    private static String licence_pwd = "Dealsline8899";
    private static String tokenString = "edb7e4ad";
    private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String phone = "15136982115";
    private static String phone2 = "19522782631";

    public LicenceUtil() {
    }

    public static void main(String[] args) {
        System.out.println(directory);
        String licenceString = createNewLicence("2023-06-01 00:00:00", "2024-06-1 00:00:00");
        System.out.println(licenceString);
        boolean valid = checkLicenceValid(licenceString);
        System.out.println(valid);
    }

    public static void initLicence() throws Exception {
        String licenceString = createNewLicence("2020-06-01 00:00:00", "2022-05-20 00:00:00");
        System.out.println(licenceString);
        File licence = new File(directory + File.separator + filename);
        if (!licence.exists()) {
            licence.createNewFile();
            log.info("开始创建licence");
        }

        FileOutputStream shout = new FileOutputStream(licence);
        shout.write(licenceString.getBytes());
        shout.close();
    }

    public static boolean checkLocalLicence() {
        try {
            File licenceFile = new File(directory, filename);
            if (!licenceFile.exists()) {
                log.error("证书不存在");
                return false;
            } else {
                StringBuffer contentBuffer = new StringBuffer();
                InputStreamReader read = new InputStreamReader(new FileInputStream(licenceFile), "utf-8");
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while((lineTxt = bufferedReader.readLine()) != null) {
                    contentBuffer.append(lineTxt);
                }

                read.close();
                String contentString = contentBuffer.toString();
                boolean valid = false;
                if (StringUtils.isNotBlank(contentString)) {
                    valid = checkLicenceValid(contentString);
                } else {
                    log.error("证书内容为空");
                }

                return valid;
            }
        } catch (Exception var7) {
            log.error(var7.toString());
            log.error(var7.getLocalizedMessage());
            log.error(var7.getCause().toString());
            return false;
        }
    }

    public static String createNewLicence(String start_time, String end_time) {
        String licenceString = null;

        try {
            Map<String, String> contentMap = new HashMap();
            contentMap.put("version", "1.0");
            contentMap.put("start_time", start_time);
            contentMap.put("end_time", end_time);
            contentMap.put("author", "jameson");
            String linkMapString = createLinkString(contentMap);
            System.out.println(linkMapString);
            String signString = sign(linkMapString, tokenString);
            contentMap.put("sign", signString);
            String contentString = mapToXml(contentMap);
            licenceString = AESUtil.encrypt(contentString, licence_pwd);
            System.out.println(licenceString);
        } catch (Exception var7) {
            log.error(var7.toString());
        }

        return licenceString;
    }

    public static boolean checkLicenceValid(String licenceString) {
        boolean result;

        try {
            String contentString = AESUtil.decrypt(licenceString, licence_pwd);
            Map<String, String> conentMap = xmlToMap(contentString);
            String version = conentMap.get("version");
            String startTime = conentMap.get("start_time");
            String endTime = conentMap.get("end_time");
            String author = conentMap.get("author");
            String sign = conentMap.get("sign");
            if (sFormat.parse(endTime).getTime() < (new Date()).getTime()) {
                log.info("证书已过期");
                result = false;
                return false;
            }

            Map<String, String> signMap = new HashMap();
            signMap.put("version", version);
            signMap.put("start_time", startTime);
            signMap.put("end_time", endTime);
            signMap.put("author", author);
            if (!sign(createLinkString(signMap), tokenString).equals(sign)) {
                System.out.println("证书签名校验错误，无效的证书");
                result = false;
                return result;
            }

            result = true;
        } catch (Exception var10) {
            log.error(var10.toString());
            result = false;
        }

        return result;
    }

    public static Map<String, String> xmlToMap(String strXML) throws Exception {
        try {
            Map<String, String> data = new HashMap();
            DocumentBuilder documentBuilder = newDocumentBuilder();
            InputStream stream = new ByteArrayInputStream(strXML.getBytes("UTF-8"));
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();

            for(int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == 1) {
                    Element element = (Element)node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }

            try {
                stream.close();
            } catch (Exception var9) {
            }

            return data;
        } catch (Exception var10) {
            throw var10;
        }
    }

    public static String mapToXml(Map<String, String> data) throws Exception {
        Document document = newDocument();
        Element root = document.createElement("xml");
        document.appendChild(root);

        for (String key : data.keySet()) {
            String value = data.get(key);
            if (value == null) {
                value = "";
            }

            value = value.trim();
            Element filed = document.createElement(key);
            filed.appendChild(document.createTextNode(value));
            root.appendChild(filed);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty("encoding", "UTF-8");
        transformer.setOutputProperty("indent", "yes");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String output = writer.getBuffer().toString();

        try {
            writer.close();
        } catch (Exception var10) {
        }

        return output;
    }

    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        documentBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        documentBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        documentBuilderFactory.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
        documentBuilderFactory.setXIncludeAware(false);
        documentBuilderFactory.setExpandEntityReferences(false);
        return documentBuilderFactory.newDocumentBuilder();
    }

    public static Document newDocument() throws ParserConfigurationException {
        return newDocumentBuilder().newDocument();
    }

    public static String createLinkString(Map<String, String> map) {
        ArrayList<String> keys = new ArrayList(map.keySet());
        Collections.sort(keys);
        String prestr = "";

        for(int i = 0; i < keys.size(); ++i) {
            String key = keys.get(i);
            String value = map.get(key);
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    public static String sign(String srcSignPacket, String privateKey) throws Exception {
        return sha1(srcSignPacket + "privateKey");
    }

    public static String sha1(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        byte[] b = data.getBytes();
        md.update(b);
        byte[] b2 = md.digest();
        int len = b2.length;
        String str = "0123456789abcdef";
        char[] ch = str.toCharArray();
        char[] chs = new char[len * 2];
        int i = 0;

        for(int k = 0; i < len; ++i) {
            byte b3 = b2[i];
            chs[k++] = ch[b3 >>> 4 & 15];
            chs[k++] = ch[b3 & 15];
        }

        return new String(chs);
    }
}
