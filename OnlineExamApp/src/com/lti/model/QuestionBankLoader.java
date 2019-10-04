package com.lti.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public static List<Question> loadQuestionOnJava() {
		QuestionBank qb = new QuestionBank();

		Subject s = new Subject();
		s.setName("Java");
		qb.addNewSubject(s);

		Question q= new Question();
		q.setQuestion("What is G1 in  java?");
		List<Option> ops = new ArrayList<Option>();
		ops.add(new Option("G1 is a Garbage Collector",true));
		ops.add(new Option("G1 is another name for jeevan",false));
		ops.add(new Option("G1 is the name of a spy agent",false));
		ops.add(new Option("G1 is a sequel of the Ra-one",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);

		q= new Question();
		q.setQuestion("What is the full form of JVM");
		ops = new ArrayList<Option>();
		ops.add(new Option("Java Virtual Machine",true));
		ops.add(new Option("Just Very Mature",false));
		ops.add(new Option("Jerry Virtual Machine",false));
		ops.add(new Option("James Victor Morgan",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);

		q= new Question();
		q.setQuestion("What is the full form of JDK");
		ops = new ArrayList<Option>();
		ops.add(new Option("Java Development Kit",true));
		ops.add(new Option("Java Default Kit",false));
		ops.add(new Option("Jerry Destructor Kit",false));
		ops.add(new Option("Java Delimiter Kit",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);

		q= new Question();
		q.setQuestion("What is the full form of JRE");
		ops = new ArrayList<Option>();
		ops.add(new Option("Java Runtime Environment",true));
		ops.add(new Option("Just Random Experiments",false));
		ops.add(new Option("Jerry Random Expiry",false));
		ops.add(new Option("James Richard Ernst",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);

		q= new Question();
		q.setQuestion("Java ka Baap kaun hai ??");
		ops= new ArrayList<Option>();
		ops.add(new Option("James Gosling",true));
		ops.add(new Option("James Bond",false));
		ops.add(new Option("James Rodriguez",false));
		ops.add(new Option("James Trump",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);

		return qb.getQuestionFor(s);
	}
}