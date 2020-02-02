package com.tutorial.readinglist.readingList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/list")
public class ReadingListController {

	private ReadingListRepository readingListRepository;
	private AmazonProperties amazonProp;
	
	@Autowired
	public ReadingListController(ReadingListRepository readingListRepository,
			AmazonProperties amazonProperties) {
		this.readingListRepository = readingListRepository;
		this.amazonProp = amazonProperties;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String readersBooks(Reader reader, Model model) {
		List<Book> readingList = 
				readingListRepository.findByReader(reader);
		if(readingList != null) {
			model.addAttribute("books", readingList);//key "books" put into model
			model.addAttribute("reader",reader);
			model.addAttribute("amazonID", amazonProp.getAssociateId());
		}
		return "readingList";//name of view to render model
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addToReadingList(Reader reader, Book book) {//binding data in body to Book object
		book.setReader(reader);//set Book object with reader property -> readers name
		readingListRepository.save(book);//save book obj via repo
		return "redirect:/";//return will handle by other controller method
	}
}
