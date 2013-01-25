package my.gallery.mvc;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

import my.gallery.domain.Cat;
import my.gallery.service.CatService;

public class CatController extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	private CatService catService = new CatService();

	private Cat chosenCat = catService.GetFirstCat();

	@Wire
	private Listbox catListbox;
	@Wire
	private Label comment;
	@Wire
	private Label name;
	@Wire
	private Image pic;
	@Wire
	private Include inner;
	@Wire
	private Textbox nameTextbox;
	@Wire
	private Textbox pictureTextbox;
	@Wire
	private Textbox commentTextbox;
	@Wire
	private Textbox addNameTextbox;
	@Wire
	private Textbox addPictureTextbox;
	@Wire
	private Textbox addCommentTextbox;
	@Wire
	private Button editButton;
	@Wire
	private Button addButton;
	@Wire
	private Button addCatButton;
	@Wire
	private Vbox vboxEdit;
	@Wire
	private Vbox vboxAdd;

	@Listen("onClick = #saveCatButton")
	public void save() {
		vboxEdit.setVisible(false);
		editButton.setVisible(true);
		chosenCat.setName(nameTextbox.getValue());
		chosenCat.setPictureSrc(pictureTextbox.getValue());
		chosenCat.setComment(commentTextbox.getValue());
		catService.UpdateCat(chosenCat);
	}

	@Listen("onClick = #addCatButton")
	public void addCat() {
		Cat newCat = new Cat();
		newCat.setNr(catService.GetLastCat().getNr() + 1);
		newCat.setName(addNameTextbox.getValue());
		newCat.setPictureSrc(addPictureTextbox.getValue());
		newCat.setComment(addCommentTextbox.getValue());
		catService.AddCat(newCat);
		vboxAdd.setVisible(false);
		addCatButton.setVisible(false);
		addButton.setVisible(true);
	}

	@Listen("onClick = #editButton")
	public void edit() {
		// inner.setSrc("CatEdit.zul");
		vboxEdit.setVisible(true);
		editButton.setVisible(false);
		nameTextbox.setValue(chosenCat.getName());
		pictureTextbox.setValue(chosenCat.getPictureSrc());
		commentTextbox.setValue(chosenCat.getComment());

	}

	@Listen("onClick = #addButton")
	public void add() {
		// inner.setSrc("CatEdit.zul");
		vboxAdd.setVisible(true);
		addCatButton.setVisible(true);
		addButton.setVisible(false);
		// addNameTextbox.setValue(chosenCat.getName());
		// addPictureTextbox.setValue(chosenCat.getPictureSrc());
		// addCommentTextbox.setValue(chosenCat.getComment());

	}

	@Listen("onClick = #prevButton")
	public void prev() {
		vboxEdit.setVisible(false);
		editButton.setVisible(true);
		if (chosenCat.getNr() == 1) {
			chosenCat = catService.GetLastCat();
			name.setValue(chosenCat.getName());
			pic.setSrc(chosenCat.getPictureSrc());
			comment.setValue(chosenCat.getComment());
		} else {
			chosenCat = catService.GetCat(chosenCat.getNr() - 1);
			name.setValue(chosenCat.getName());
			pic.setSrc(chosenCat.getPictureSrc());
			comment.setValue(chosenCat.getComment());
		}
	}

	@Listen("onClick = #nextButton")
	public void next() {
		vboxEdit.setVisible(false);
		editButton.setVisible(true);
		if (chosenCat.getNr() == catService.GetLastCat().getNr()) {
			chosenCat = catService.GetFirstCat();
			name.setValue(chosenCat.getName());
			pic.setSrc(chosenCat.getPictureSrc());
			comment.setValue(chosenCat.getComment());
		} else {
			chosenCat = catService.GetCat(chosenCat.getNr() + 1);
			name.setValue(chosenCat.getName());
			pic.setSrc(chosenCat.getPictureSrc());
			comment.setValue(chosenCat.getComment());
		}
	}	
}
