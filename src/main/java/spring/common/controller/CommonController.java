package spring.common.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.common.common.CommandMap;
import spring.common.service.CommonService;


@Controller
public class CommonController {
    Logger log = LoggerFactory.getLogger(this.getClass());
     
    @Autowired
    private CommonService commonService;
    
    @RequestMapping(value="/common/downloadFile.do")
    public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception{
        Map<String,Object> map = commonService.selectFileInfo(commandMap.getMap());
        String storedFileName = (String)map.get("STORED_FILE_NAME");
        String originalFileName = (String)map.get("ORIGINAL_FILE_NAME");
         
        byte fileByte[] = FileUtils.readFileToByteArray(new File("D:\\study\\file\\"+storedFileName));
         
        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
         
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
