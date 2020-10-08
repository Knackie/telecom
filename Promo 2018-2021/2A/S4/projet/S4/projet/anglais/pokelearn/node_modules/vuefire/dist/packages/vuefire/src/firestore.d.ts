import { bindCollection, bindDocument, FirestoreOptions } from '@posva/vuefire-core';
import { firestore } from 'firebase';
import Vue, { PluginFunction } from 'vue';
interface PluginOptions {
    bindName?: string;
    unbindName?: string;
    serialize?: FirestoreOptions['serialize'];
    reset?: FirestoreOptions['reset'];
    wait?: FirestoreOptions['wait'];
}
declare module 'vue/types/vue' {
    interface Vue {
        $bind(name: string, reference: firestore.Query | firestore.CollectionReference, options?: FirestoreOptions): Promise<firestore.DocumentData[]>;
        $bind(name: string, reference: firestore.DocumentReference, options?: FirestoreOptions): Promise<firestore.DocumentData>;
        $unbind: (name: string, reset?: FirestoreOptions['reset']) => void;
        $firestoreRefs: Readonly<Record<string, firestore.DocumentReference | firestore.CollectionReference>>;
        _firestoreUnbinds: Readonly<Record<string, ReturnType<typeof bindCollection | typeof bindDocument>>>;
    }
}
declare type VueFirestoreObject = Record<string, firestore.DocumentReference | firestore.Query | firestore.CollectionReference>;
declare type FirestoreOption<V> = VueFirestoreObject | ((this: V) => VueFirestoreObject);
declare module 'vue/types/options' {
    interface ComponentOptions<V extends Vue> {
        firestore?: FirestoreOption<V>;
    }
}
export declare const firestorePlugin: PluginFunction<PluginOptions>;
export {};
