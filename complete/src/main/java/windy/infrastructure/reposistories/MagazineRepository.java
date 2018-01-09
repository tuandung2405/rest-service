package windy.infrastructure.reposistories;

import java.util.UUID;

import windy.infrastructure.domains.Magazine;

public class MagazineRepository extends BaseRepository<Magazine>{

	public MagazineRepository(Class<Magazine> clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}


	public MagazineRepository() {
		super(Magazine.class);
		justTest();
	}
	
	private void justTest() {
		Magazine magazine = new Magazine(UUID.randomUUID());
		magazine.setTitle("magazine");
		magazine.setAuthor("duong1");
		magazine.setCreatedAt(System.currentTimeMillis());
		magazine.setPublishedDate(System.currentTimeMillis());
		magazine.setActive(true);
		magazine.setCount(1);
        list.add(magazine);
	}
}
