#include <stdio.h>
#include <stdlib.h>

void euclidean(long int num1, long int num2) {
	long int a = num1, b = num2, temp;
	printf("\n%ld = %ld(%ld) + %ld", a, (a / b), b, (a % b));

	while(a % b != 0) {
		temp = a % b;
		a = b;
		b = temp;
		printf("\n%ld = %ld(%ld) + %ld", a, (a / b), b, (a % b));
	}

	printf("\n");
	printf("\ngcd(%ld, %ld) = %ld", num1, num2, b);
	printf("\nlcm(%ld, %ld) = %ld", num1, num2, ((num1 * num2) / b));
	printf("\n\n");
}

int main(int argc, char **argv) {
	printf("\n*** C EUCLIDAN ALGORITHM CALCULATOR ***\n");
	if(argc != 3) {
		printf("Usage: %s num1 num2\n", argv[0]);
		return -1;
	}

	char *ptr;	// if it contains anything, there is something wrong with the input number
	long int num1 = strtol(argv[1], &ptr, 10);
	if(!*argv[1] || *ptr)
		printf("Invalid number %s\n\n", argv[1]);
	long int num2 = strtol(argv[2], &ptr, 10);
	if(!*argv[2] || *ptr)
		printf("Invalid number %s\n\n", argv[2]);

	euclidean(num1, num2);

	return 0;
}