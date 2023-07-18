package practice2023;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchWorkToInterest {

    public Map<Work, Person> assignWorkByInterest(List<Work> projects, List<Person> volunteers) {
        if(projects == null || projects.isEmpty() || volunteers == null || volunteers.isEmpty()) {
            return null;
        }

        Map<String, Person> volunteerInterest = new HashMap<>();
        Map<String, Work> requiredSkills = new HashMap<>();

        for(Work project: projects) {
            for(String tag : project.getTags()) {
                requiredSkills.put(tag, project);
            }
        }

        for(Person volunteer: volunteers) {
            for(String tag : volunteer.getInterests()) {
                volunteerInterest.put(tag, volunteer);
            }
        }

        Map<Work, Person> assignments = new HashMap<>();

        for(String skill : requiredSkills.keySet()) {
            Work project = requiredSkills.get(skill);
            Person person = volunteerInterest.get(skill);
            assignments.put(project,person);
        }
        return assignments;
    }
}

class Work {
    String name;
    List<String> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

class Person {
    String name;
    List<String> interests;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
