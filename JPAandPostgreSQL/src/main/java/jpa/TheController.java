package jpa;

/**
 *
 * @author saara
 */
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TheController {

    ArrayList<String> listvalues = new ArrayList<>();
    ArrayList<String> books = new ArrayList<>();
    ArrayList<String> movies = new ArrayList<>();
    ArrayList<String> formdata = new ArrayList<>();
    private Date sysdate;

    @Autowired
    ListvaluesRepository listvaluesrepository;

    @Autowired
    FormdataRepository formdatarepository;

    @RequestMapping("/")
    public String home(Model model) {

        listvalues.clear();
        books.clear();
        movies.clear();
        formdata.clear();

        for (Listvalues listvalues : listvaluesrepository.findAll()) {
            if (listvalues.getListnumber() == 1) {
                this.books.add(listvalues.getValue());
            } else {
                this.movies.add(listvalues.getValue());
            }
        }

        for (Formdata formdata : formdatarepository.findAll()) {
            this.formdata.add(formdata.getValue() + " inserted at: " + formdata.getDate());
        }

        model.addAttribute("text", "Our dynamic form!");
        model.addAttribute("books", books);
        model.addAttribute("movies", movies);
        model.addAttribute("formdata", formdata);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String save(@RequestParam String book, @RequestParam String movie) {

        if (!book.trim().isEmpty()) {
            sysdate = new Date();
            formdatarepository.save(new Formdata(sysdate, book));
        }
        if (!movie.trim().isEmpty()) {
            sysdate = new Date();
            formdatarepository.save(new Formdata(sysdate, movie));
        }
        return "redirect:/";
    }

}
