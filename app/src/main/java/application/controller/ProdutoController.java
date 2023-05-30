package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Produto;
import application.model.ProdutoRepository;

@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepo;

    @RequestMapping("/produto")
    public String list(Model model) {
        model.addAttribute("produtos", produtoRepo.findAll());
        return "WEB-INF/list.jsp";

    }

    @RequestMapping("/insert")
    public String insert() {
        return "WEB-INF/insert.jsp";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo, @RequestParam("descricao") String descricao) {
        Produto produto = new Produto();
        produto.setTitulo(titulo);
        produto.setDescricao(descricao);

        produtoRepo.save(produto);

        return "redirect:/produto";
    }

    @RequestMapping("/update")
    public String update(Model model, @RequestParam("id") int id) {
        Optional<Produto> produto = produtoRepo.findById(id);

        if(!produto.isPresent()) {
            return "redirect:/produto";
        }

        model.addAttribute("produto", produto.get());
        return "WEB-INF/update.jsp";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
        @RequestParam("titulo") String titulo,
        @RequestParam("id") int id,
        @RequestParam("descricao") String descricao
        
    ) {
        Optional<Produto> produto = produtoRepo.findById(id);
        if(!produto.isPresent()) {
            return "redirect:/produto";
        }

        produto.get().setTitulo(titulo);
        produto.get().setDescricao(descricao);

        produtoRepo.save(produto.get());
        return "redirect:/produto";
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        Optional<Produto> produto = produtoRepo.findById(id);

        if(!produto.isPresent()) {
            return "redirect:/produto";
        }

        model.addAttribute("produto", produto.get());
        return "WEB-INF/delete.jsp";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id) {
        produtoRepo.deleteById(id);
        return "redirect:/produto";
    }


}
