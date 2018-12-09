/*
 * Copyright 2010 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;

public enum ArithmeticOperatorReplacementMutator4 implements MethodMutatorFactory {

    MATH_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
            final MethodVisitor methodVisitor) {
        return new MathMethodVisitor4(this, methodInfo, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        return name();
    }

}

class MathMethodVisitor4 extends AbstractInsnMutator {

    MathMethodVisitor4(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
            final MethodVisitor writer) {
        super(factory, methodInfo, context, writer);
    }

    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

    static {

        // ints

        MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IOR, "Replaced integer addition with OR"));
        MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IAND, "Replaced integer subtraction with AND"));
        MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IREM, "Replaced integer multiplication with modulus"));
        MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.IXOR, "Replaced integer division with XOR"));
        MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.ISHL, "Replaced bitwise OR with Shift Left"));
        MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.ISHR, "Replaced bitwise AND with Shift Right"));
        MUTATIONS.put(Opcodes.IREM,
                new InsnSubstitution(Opcodes.IUSHR, "Replaced integer modulus with Unsigned Shift Right"));
        MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.IADD, "Replaced XOR with addition"));
        MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.ISUB, "Replaced Shift Left with subtraction"));
        MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IMUL, "Replaced Shift Right with multiplication"));
        MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IDIV, "Replaced Unsigned Shift Right with division"));

        // longs
        //

        MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LOR, "Replaced integer addition with OR"));
        MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LAND, "Replaced integer subtraction with AND"));
        MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LREM, "Replaced integer multiplication with modulus"));
        MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LXOR, "Replaced integer division with XOR"));
        MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LSHR, "Replaced bitwise AND with Shift Right"));
        MUTATIONS.put(Opcodes.LREM,
                new InsnSubstitution(Opcodes.LUSHR, "Replaced integer modulus with Unsigned Shift Right"));
        MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LADD, "Replaced XOR with addition"));
        MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LSUB, "Replaced Shift Left with subtraction"));
        MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LMUL, "Replaced Shift Right with multiplication"));
        MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LDIV, "Replaced Unsigned Shift Right with division"));

        // floats
        MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.FREM, "Replaced float addition with modulus"));
        MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.FADD, "Replaced float subtraction with addition"));
        MUTATIONS.put(Opcodes.FMUL,
                new InsnSubstitution(Opcodes.FSUB, "Replaced float multiplication with subtraction"));
        MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.FMUL, "Replaced float division with multiplication"));
        MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.FDIV, "Replaced float modulus with division"));

        // doubles
        MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.DREM, "Replaced double addition with modulus"));
        MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.DADD, "Replaced double subtraction with addition"));
        MUTATIONS.put(Opcodes.DMUL,
                new InsnSubstitution(Opcodes.DSUB, "Replaced double multiplication with subtraction"));
        MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.DMUL, "Replaced double division with multiplication"));
        MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.DDIV, "Replaced double modulus with division"));
    }

    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
        return MUTATIONS;
    }

}
