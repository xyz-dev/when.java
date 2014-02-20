/*
 * The MIT License (MIT)
 * Copyright © 2013 Englishtown <opensource@englishtown.com>
 * http://englishtown.mit-license.org/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.englishtown.promises;

/**
 * A {@link com.englishtown.promises.WhenProgress} with void progress
 */
public class When<T> extends WhenProgress<T, Void> {

    /**
     * Creates a new {@link com.englishtown.promises.DeferredProgress} with fully isolated resolver and promise parts,
     * either or both of which may be given out safely to consumers.
     *
     * @return new {@link com.englishtown.promises.DeferredProgress}
     */
    @Override
    public Deferred<T> defer() {
        final DeferredProgress<T, Void> d = super.defer();

        return new Deferred<T>() {
            @Override
            public Resolver<T, Void> getResolver() {
                return d.getResolver();
            }

            @Override
            @SuppressWarnings("unchecked")
            public Promise<T> getPromise() {
                return (Promise<T>) d.getPromise();
            }
        };
    }

    /**
     * Returns promiseOrValue if promiseOrValue is a {@link com.englishtown.promises.ProgressPromise}, a new com.englishtown.promises.ProgressPromise if
     * promiseOrValue is a foreign promise, or a new, already-fulfilled {@link com.englishtown.promises.ProgressPromise}
     * whose value is promiseOrValue if promiseOrValue is an immediate value.
     *
     * @param value a value to wrap in a resolved promise
     * @return a new already-fulfilled trusted {@link com.englishtown.promises.ProgressPromise} for the provided value
     */
    @Override
    @SuppressWarnings("unchecked")
    public Promise<T> resolve(T value) {
        return (Promise<T>) super.resolve(value);
    }

    /**
     * Returns a rejected promise for the supplied value.  The returned promise will be rejected with the
     * supplied value.
     *
     * @param value the rejected value of the returned {@link com.englishtown.promises.ProgressPromise}
     * @return a rejected {@link com.englishtown.promises.ProgressPromise}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Promise<T> reject(T value) {
        return (Promise<T>) super.reject(value);
    }

    /**
     * Returns a rejected promise for the supplied value.  The returned promise will be rejected with the
     * supplied value.
     *
     * @param value the rejected value of the returned {@link com.englishtown.promises.ProgressPromise}
     * @return a rejected {@link com.englishtown.promises.ProgressPromise}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Promise<T> reject(Value<T> value) {
        return (Promise<T>) super.reject(value);
    }

    /**
     * Returns a rejected promise for the supplied value.  The returned promise will be rejected with the
     * supplied error for the value.
     *
     * @param error the rejected error value of the returned {@link com.englishtown.promises.ProgressPromise}
     * @return a rejected {@link com.englishtown.promises.ProgressPromise}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Promise<T> reject(Throwable error) {
        return (Promise<T>) super.reject(error);
    }

    @Override
    protected WhenProgress<T, Void>.PromiseImpl createPromise(Thenable<T, Void> then) {
        return new PromiseImpl2(then);
    }

    protected class PromiseImpl2 extends PromiseImpl implements Promise<T> {

        PromiseImpl2(Thenable<T, Void> then) {
            super(then);
        }

    }

}
