package com.ledsonsilva.bravi.util;

import java.util.Stack;

public class BalanceBracketsUtil {

    /**
     * Balance Brackets Util
     *
     * Solução:
     *
     * Transforma a string em um array de caracteres, cria uma pilha vazia, percorre o array de caracteres,
     * iterando no topo da pilha o valor corrente do loop quando for chaves de abertura "{", "[", "(", quando os
     * valores correntes forem de fechamento "}", "]", "(" guarda o valor em uma variavel temporária e remove o topo
     * da pilha, e por ultimo faz a comparação se o que foi retirado do topo da pilha é a abertura do fechamento que
     * está dentro do loop corrente.
     *
     * @param brackets String
     * @return Boolean
     */
    public static boolean isValid(String brackets) {

        int length = brackets.length();
        char [] array = brackets.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<length; i++) {

            if (array[i]=='(' || array[i]=='{' || array[i]=='[' ){
                stack.push(array[i]);
            }

            if (array[i]==')' ||array[i]=='}' ||array[i]==']') {

                if(stack.isEmpty()) return false;

                char temp=stack.pop();

                if((temp=='(' && array[i]==')') || (temp=='{' && array[i]=='}') ||(temp=='[' && array[i]==']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }

}
