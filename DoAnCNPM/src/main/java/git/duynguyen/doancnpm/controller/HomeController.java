package git.duynguyen.doancnpm.controller;

import git.duynguyen.doancnpm.service.PoisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    // Map URL "/" tới file templates/home.html
    @Autowired
    private PoisService poisService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Trang chủ");
        return "layout/login"; // Trả về tên file (không cần đuôi .html)
    }

    // Map URL "/profile" tới file templates/user/profile.html
    @GetMapping("/monitoring")
    public String pageMonitoring() {
        return "admin/monitoring";
    }
    // Map URL "/profile" tới file templates/user/profile.html
    @GetMapping("/pipeline")
    public String pagePipeline() {
        return "admin/pipeline";
    }
    // Map URL "/profile" tới file templates/user/profile.html
    @GetMapping("/poi-manage")
    public String pagePoiManage(Model model) {
        model.addAttribute("pois", poisService.getPoisList());
        return "admin/poi-manage";
    }
    // Map URL "/profile" tới file templates/user/profile.html
    @GetMapping("/route-manage")
    public String pageRoute() {
        return "admin/route-manage";
    }
    // Map URL "/profile" tới file templates/user/profile.html
    @GetMapping("/system-logs")
    public String pageSystemLogs() {
        return "admin/system-logs";
    }
}
