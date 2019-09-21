package com.cxk.util;

public class UploadUtil {

   /* @RequestMapping(value = "/ajaxUpload", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public int ajaxUpload(@RequestPart(value = "files", required = false) MultipartFile[] files, @RequestParam Map<String, Object> mp, @RequestParam(required = false) List<String> loves) throws Exception {
        for (MultipartFile file : files) {
            //判断文件非空，上传
            if (!file.isEmpty()) {
                //1、连接ftp服务器
                FTPClient ftpClient = new FTPClient();
                ftpClient.setConnectTimeout(100000);
                ftpClient.connect("47.102.198.5", 21);
                //2、登录ftp服务器
                ftpClient.login("ftpuser", "root");
                ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
                //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                InputStream is = file.getInputStream();
                //4、上传文件
                // 1）指定上传目录
                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
                //2）指定文件类型
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流
                ftpClient.storeFile("帅锅锅.jpg", is);
                //5、退出登录
                ftpClient.logout();
            }
        }
        return 1;
    }*/

}

