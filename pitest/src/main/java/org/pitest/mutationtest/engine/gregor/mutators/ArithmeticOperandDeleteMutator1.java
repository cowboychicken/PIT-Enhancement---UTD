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

public enum ArithmeticOperandDeleteMutator1 implements MethodMutatorFactory {

    MATH_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
            final MethodVisitor methodVisitor) {
        return new AodVisitor1(this, methodInfo, context, methodVisitor);
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

class AodVisitor1 extends AbstractInsnMutator {

    AodVisitor1(final MethodMutatorFactory factory, final MethodInfo methodInfo, final MutationContext context,
            final MethodVisitor writer) {
        super(factory, methodInfo, context, writer);
    }

    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

    static {
        // ints
        MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));

        // floats
        MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LOR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.POP, "Replaced equation with first operand"));

        // longs
        MUTATIONS.put(Opcodes.FADD, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.FSUB, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.FMUL, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.FDIV, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.FREM, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));

        // doubles
        MUTATIONS.put(Opcodes.DADD, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.DSUB, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.DMUL, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.DDIV, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));
        MUTATIONS.put(Opcodes.DREM, new InsnSubstitution(Opcodes.POP2, "Replaced equation with first operand"));

    }

    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
        return MUTATIONS;
    }

}
