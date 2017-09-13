/*
 * p3.h
 *
 *  Created on: Feb 28, 2017
 *      Author: Jake
 */

#ifndef P3_H_
#define P3_H_

#define LEN 7
typedef enum{T, F}boolean;

typedef enum{START, INTEGER, DECIMAL, END}State;

typedef struct
{
 double p;
 int s;
 double v;
}
InterimResult;

typedef struct
{
	State currentState;
	boolean (*inputVerifier)(char);
	InterimResult (*action)(InterimResult, char);
	State nextState;
}
Edge;

double parseNum(char *text);
Edge searchForEdge(State currentState, char ch);
InterimResult initialize(InterimResult x);
boolean digitInputVerifier(char c);
boolean plusInputVerifier(char c);
boolean minusInputVerifier(char c);
boolean periodInputVerifier(char c);
InterimResult continuingIntegerAction(InterimResult x, char c);
InterimResult continuingFractionAction(InterimResult x, char c);
InterimResult valueIsDigitAction(InterimResult x, char c);
InterimResult startFraction(InterimResult x, char c);
InterimResult negateAction(InterimResult x, char c);
InterimResult noAction(InterimResult x, char c);

const Edge machine[] =
{
		{START, &digitInputVerifier, &valueIsDigitAction, INTEGER},
		{START, &minusInputVerifier, &negateAction, INTEGER},
		{START, &plusInputVerifier, &noAction, INTEGER},
		{START, &periodInputVerifier, &startFraction, DECIMAL},
		{INTEGER, &digitInputVerifier, &continuingIntegerAction, INTEGER},
		{INTEGER, &periodInputVerifier, &startFraction, DECIMAL},
		{DECIMAL, &digitInputVerifier, &continuingFractionAction, DECIMAL}
};

#endif /* P3_H_ */
