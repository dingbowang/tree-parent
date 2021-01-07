package com.stone.tree.util;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author dbw
 * @date 2021/01/07/11:06 下午
 * @Description
 */
@Component
public class FastDFSUtil {
    private static final Logger logger = LoggerFactory.getLogger(FastDFSUtil.class);

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    public String upload(MultipartFile file) throws IOException {
        logger.info("com.stone.tree.util-->upload::file = [{}]",file);
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    public void deleteFile(String url){
        logger.info("com.stone.tree.util-->deleteFile::url = [{}]",url);
        fastFileStorageClient.deleteFile(url);
    }
}
