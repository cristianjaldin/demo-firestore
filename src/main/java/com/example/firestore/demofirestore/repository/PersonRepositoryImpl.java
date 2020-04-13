package com.example.firestore.demofirestore.repository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.firestore.demofirestore.entity.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
	// https://cloud.spring.io/spring-cloud-gcp/spring-cloud-gcp.html#spring-cloud-gcp-core
	@Autowired
	private Firestore firestore;

	@Override
	public Person add(Person person) throws InterruptedException, ExecutionException {
		// coleccion/idDocumento
		WriteResult writeResult = this.firestore.document("person/" + person.getId()).set(person).get();
		System.out.println("Update time: " + writeResult.getUpdateTime());
		return person;
	}

	@Override
	public Person get(long id) throws InterruptedException, ExecutionException {
		// ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = this.firestore.document("persons/cris").get();
		ApiFuture<DocumentSnapshot> documentSnapshotApiFuture = this.firestore.collection("person").document(String.valueOf(id)).get();
		Person person = documentSnapshotApiFuture.get().toObject(Person.class);
		System.out.println(person);
		return person;
	}

	@Override
	public Person delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAll() throws InterruptedException, ExecutionException {
		ApiFuture<QuerySnapshot> collectionSnapshotApiFuture = this.firestore.collection("person").get();
		List<QueryDocumentSnapshot> documents = collectionSnapshotApiFuture.get().getDocuments();
		List<Person> people = documents.stream().map(p->p.toObject(Person.class)).collect(Collectors.toList());
		return people;
	}

}