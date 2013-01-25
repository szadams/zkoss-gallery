package my.gallery.service;

import java.util.ArrayList;
import java.util.List;

import my.gallery.domain.Cat;

public class CatService {
	private List<Cat> context = new ArrayList<Cat>();

	public CatService() {
		context.add(new Cat(1, "Latający kot", "img/flying.gif",
				"Nie pacz w dół."));
		context.add(new Cat(2, "Katus humanus", "img/walking.gif",
				"Moves like Mick Jagger."));
		context.add(new Cat(3, "Wymiatacz", "img/broomcat.gif",
				"Miotła to przeżytek."));
		context.add(new Cat(4, "Maru", "img/marujump.gif",
				"Maru skacze jak się paczy."));
		context.add(new Cat(5, "Zdziwiony", "img/wowcat.gif",
				"Czy ten w lustrze to ja?"));
		context.add(new Cat(6, "Językoznawca", "img/tonguecat.gif",
				"Potrafisz tak?"));
	}

	public List<Cat> GetAllCats() {
		return context;
	}

	public Cat GetLastCat() {
		return context.get(context.size() - 1);
	}

	public Cat GetCat(int nr) {
		return context.get(nr - 1);
	}

	public void UpdateCat(Cat cat) {
		for (Cat c : context) {
			if (c.getNr() == cat.getNr()) {
				c = cat;
			}
		}
	}

	public Cat GetFirstCat() {
		return context.get(0);
	}

	public void AddCat(Cat cat) {
		if (!(cat.getPictureSrc().isEmpty() || (cat.getName().isEmpty() && cat
				.getComment().isEmpty()))) {
			context.add(cat);
		}
	}

}