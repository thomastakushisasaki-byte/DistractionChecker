package distraction_checker.demo.controller;

import distraction_checker.demo.entity.DistractionLog;
import distraction_checker.demo.repository.DistractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DistractionController {

    @Autowired
    private DistractionRepository repository;

    // トップ画面の表示
    @GetMapping("/")
    public String index(Model model) {
        // DBから全データを取得
        List<DistractionLog> logs = repository.findAll();
        // 画面（HTML）にデータを渡す
        model.addAttribute("logs", logs);
        model.addAttribute("newLog", new DistractionLog());
        return "index"; // index.htmlを呼び出す
    }

    // データの保存処理
    @PostMapping("/add")
    public String add(DistractionLog log) {
        repository.save(log);
        return "redirect:/"; // 保存したらトップに戻る
    }
}