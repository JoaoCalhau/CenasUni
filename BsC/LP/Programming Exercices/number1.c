#include <stdio.h>
#include <string.h>

#define MAX_SIZE 5

typedef struct Students {
	int age;
	float gpa;
	char grade_level[24];
	char name[24];
} Student;

typedef struct ArrayStudents {
	Student *students[MAX_SIZE];
	int ocupied;
} Array;

void make_array(Array *array) {
	Student *student = (Student *) malloc(MAX_SIZE*sizeof(Student));

	for(int i = 0; i < MAX_SIZE; i++)
		array->students[i] = (Student *) malloc(sizeof(Student));;

	array->ocupied = 0;
}

void destroy_array(Array *array) {
	for(int i = 0; i < MAX_SIZE; i++)
		free(array->students[i]);
}

void add_student(Array *array, char nome[], int idade, float gpa, char grade_level[]) {
	int i = array->ocupied;

	if (array->ocupied >= MAX_SIZE) {
		printf("Can't add anything to the array! The array is full...\n");
		printf("\n");
		return;
	} else {
		sprintf(array->students[i]->name, nome);
		sprintf(array->students[i]->grade_level, grade_level);
		array->students[i]->age = idade;
		array->students[i]->gpa = gpa;
		array->ocupied++;
	}
}

void print_student(Student *student) {
	printf("Name: %s\n", student->name);
	printf("Age: %d\n", student->age);
	printf("Grade level: %s\n", student->grade_level);
	printf("GPA: %.2f\n", student->gpa);
	printf("\n");
}

int main() {

	Array a;

	make_array(&a);
	add_student(&a, "Cenas", 18, 20, "Freshman");
	add_student(&a, "Coisas", 19, 13.90, "Senior");


	for( int i = 0; i < a.ocupied; i++)
		print_student(a.students[i]);
	/*
	printf("Name: %s\n", a.students[0]->name);
	printf("Age: %d\n", a.students[0]->age);
	printf("Grade Level: %s\n", a.students[0]->grade_level);
	printf("GPA: %.2f\n", a.students[0]->gpa);
	*/

	destroy_array(&a);

	return 0;
}