package org.mrpaulwoods.bookmarks

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.validation.Valid
import java.security.Principal

@Slf4j
@Controller
@RequestMapping
class HomeController {

    private BookmarkService bookmarkService

    HomeController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService
    }

    @GetMapping
    String index(final Model model) {
        log.info "index()"
        model.addAttribute "bookmarkForm", new BookmarkForm()
        "index"
    }

    @PostMapping("/add")
    String add(@Valid BookmarkForm bookmarkForm, BindingResult result, Model model) {
        log.info "add(bookmarkForm=$bookmarkForm)"
        if (result.hasErrors()) {
            model.addAttribute "error", "Please correct the errors below."
            "index"
        } else {
            bookmarkService.create new Bookmark(
                    name: bookmarkForm.name,
                    url: bookmarkForm.url
            )
            "redirect:/"
        }
    }

}
