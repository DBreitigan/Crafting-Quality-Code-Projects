/*
 * main.c
 *
 *  Created on: Feb 27, 2017
 *      Author: Jake
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "p3.h"


int main(void)
{
	double output = parseNum("-2553.12");
	printf("The first number is %f\n", output);

	output = parseNum("84639");
		printf("The second number is %f\n", output);

	output = parseNum(".086368");
			printf("The third number is %f\n", output);
	return 0;
}

double parseNum(char *text)
{
	InterimResult result = initialize(result);
	Edge currentEdge = machine[0];
	boolean firstPass = T;
	int length = strlen(text);
	for(int i = 0; i < length; i++)
	{
		if(firstPass == T)
		{
			firstPass = F;
			currentEdge = searchForEdge(START, *text);
		}
		else
		{
			currentEdge = searchForEdge(currentEdge.nextState, *text);
		}

		result = currentEdge.action(result, *text);
		text++;
	}
	return result.v * (double) result.s;
}

Edge searchForEdge(State currentState, char ch)
{
	for(int arrInd = 0; arrInd <= sizeof(machine)/sizeof(Edge); arrInd++)
	{
		Edge edge = machine[arrInd];
		if((edge.inputVerifier(ch) == T)&&(currentState == edge.currentState))
		{
			return machine[arrInd];
		}
	}
	printf("Edge does not exist.");
	exit(EXIT_FAILURE);
	return machine[0];
}

InterimResult initialize(InterimResult x)
{
	x.p = 0.0;
	x.s = 1;
	x.v = 0;
	return x;
}

boolean digitInputVerifier(char c)
{
	if(c >= 48 && c <= 57)
	{
		return T;
	}
	else
	{
		return F;
	}
}

boolean plusInputVerifier(char c)
{
	if(c == 43)
	{
		return T;
	}
	else
	{
		return F;
	}
}

boolean minusInputVerifier(char c)
{
	if(c == 45)
	{
		return T;
	}
	else
	{
		return F;
	}
}

boolean periodInputVerifier(char c)
{
	if(c == 46)
	{
		return T;
	}
	else
	{
		return F;
	}
}

InterimResult continuingIntegerAction(InterimResult x, char c)
{
	x.v = 10 * x.v + (c - '0');
	return x;
}

InterimResult continuingFractionAction(InterimResult x, char c)
{
	x.v += x.p * (c - '0');
	x.p = x.p / 10;
	return x;
}

InterimResult startFraction(InterimResult x, char c)
{
	x.p = 0.1;
	return x;
}

InterimResult valueIsDigitAction(InterimResult x, char c)
{
	x.v = c - '0';
	return x;
}

InterimResult negateAction(InterimResult x, char c)
{
	x.s = -1;
	return x;
}

InterimResult noAction(InterimResult x, char c)
{
	return x;
}



