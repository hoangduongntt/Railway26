import com.fsoft.entity.Group;
import com.fsoft.repository.GroupRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class TestProgram {
	public static void main(String[] args) {
		GroupRepository groupRepository = new GroupRepository();
		// getAllGroup
		List<Group> groupList = groupRepository.getAllGroup();
		System.out.println("Get All Group : " );
		for (Group group:groupList){
			System.out.println(group.toString());
		}
		// getGroupById
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Get Group By Id");
		Group groupById = groupRepository.getGroupById(1);
		System.out.println(groupById.toString());

		// getGroupByName
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Get Group By Name");
		Group groupByName = groupRepository.getGroupByName("Java Web");
		System.out.println(groupByName.toString());

//		// create Group
//		System.out.println("++++++++++++++++++++++++++++++++");
//		System.out.println("Create new Group !");
//		Group newGroup = new Group();
//		newGroup.setName("Python");
//		newGroup.setStatus("T");
//		groupRepository.createGroup(newGroup);

		// Update Group
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Update new Group !");
		Group updateGroup = new Group();
		updateGroup.setId(3);
		updateGroup.setName("Watting");
		updateGroup.setStatus("M");
		groupRepository.updateGroup(updateGroup);

		// Group Update
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Group Update !");
		groupRepository.groupUpdate(1, "C#", "M");

//		// Delete Group
//		System.out.println("++++++++++++++++++++++++++++++++");
//		System.out.println("Delete Group !");
//		groupRepository.deleteGroup(4);

		// Check GroupID
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Check Group ID Exist!");
		System.out.println(groupRepository.isGroupIdExist(1));

		// Check GroupName
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("Check GroupName Exist!");
		System.out.println(groupRepository.isGroupNameExist("C"));

	}
}
