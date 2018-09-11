package com.cse.cseservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cse.domain.Gallery;
import com.cse.domain.Location;
import com.cse.domain.Property;
import com.cse.domain.PropertyImage;
import com.cse.domain.Subarea;
import com.cse.domain.Type;
import com.cse.domain.User;
import com.cse.repository.LocationRepository;
import com.cse.repository.PropertyRepository;
import com.cse.repository.SubareaRepository;
import com.cse.repository.TypeRepository;
import com.cse.repository.UserRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class PopulateDatabase {

	@Autowired
	private PropertyRepository propertyRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private SubareaRepository subareaRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	private User user;
	
	private Type type;
	
	private Subarea subarea;
	
	private Location location;
	
	@Before
	public void before() {
		location = new Location("L1", "AGADIR", new byte[] {});
		user = new User("", "user1", "user1", null, null, null);
		subarea = new Subarea("Subarea1", 124, 3422, location);
		type = new Type("T1", "Type1");
		
		location = locationRepository.save(location);
		user = userRepository.save(user);
		subarea = subareaRepository.save(subarea);
		type = typeRepository.save(type);
	}

//	@Test
	public void populateDb() {

		for (int i = 1 ; i < 10 ; i++) {

			List<PropertyImage> images = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				PropertyImage img = new PropertyImage(new byte[] {}, new Date(), new Date(), new Date(), new Date(),
						user);
				images.add(img);
			}

			Gallery gallery = new Gallery(images);


			Property property = new Property("PROP" + i, "Property " + i, "A property number " + i, new Date(), new Date(),
					new Date(2015 + i - 1900, 12, 12), new Date(), 42 * i, gallery, user, user,
					type , subarea, 12, 4, 134);
			this.propertyRepository.save(property);
		}
		assertEquals(1, 1);

	}

}
