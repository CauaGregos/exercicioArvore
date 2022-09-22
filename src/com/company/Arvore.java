package com.company;

import java.util.Objects;

public class Arvore <X extends Comparable<X>> // angle brackets
{


    private class No
    {
        private X  info;
        private No esq,dir;

        public No (X i)
        {
            this.esq =null;
            this.info=i;
            this.dir =null;
        }

        public No (No e, X i, No d)
        {
            this.esq =e;
            this.info=i;
            this.dir =d;
        }

        public No getEsq ()
        {
            return this.esq;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getDir ()
        {
            return this.dir;
        }

        public void setEsq (No e)
        {
            this.esq=e;
        }

        public void setInfo (X i)
        {
            this.info=i;
        }

        public void setDir (No d)
        {
            this.dir=d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            No no = (No) o;
            return Objects.equals(info, no.info) && Objects.equals(esq, no.esq) && Objects.equals(dir, no.dir);
        }

        @Override
        public int hashCode() {
            return Objects.hash(info, esq, dir);
        }
    }

    private No raiz=null;

    public void inclua (X i) throws Exception
    {
        if (i==null) throw new Exception ("Informacao Ausente");

        if (this.raiz==null)
        {
            this.raiz = new No (i);
            return;
        }

        No  ant=null, atual=this.raiz;
        int comp;

        do
        {
            comp = i.compareTo(atual.getInfo());

            if (comp==0) throw new Exception ("Elemento repetido");

            ant=atual;
            if (comp<0)
                atual=atual.getEsq();
            else
                atual=atual.getDir();
        }
        while (atual!=null);

        if (comp<0)
            ant.setEsq(new No (i));
        else
            ant.setDir(new No (i));
    }


    private String preOrdem (No r)
    {
        if (r==null) return "";

        return r.getInfo()+" "+
                this.preOrdem(r.getEsq())+" "+
                this.preOrdem(r.getDir());
    }

    private int getQtdNos (No r)
    {
        if (r == null) return 0;
        else return 1 + getQtdNos(r.esq) + getQtdNos(r.dir);
    }

    public boolean tem(X a){

       return tem(this.raiz.getInfo());

    }

    public int getQtdNos ()
    {
        return this.getQtdNos(this.raiz);
    }

    private String inOrdem (No r)
    {
        if (r==null) return "";

        return this.inOrdem(r.getEsq())+" "+
                r.getInfo()+" "+
                this.inOrdem(r.getDir());
    }

    private String posOrdem (No r)
    {
        if (r==null) return "";

        return this.posOrdem(r.getEsq())+" "+
                this.posOrdem(r.getDir())+" "+
                r.getInfo();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arvore<?> arvore = (Arvore<?>) o;
        return Objects.equals(raiz, arvore.raiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raiz);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString ()
    {
        String pre=this.preOrdem(this.raiz),
                in =this.inOrdem (this.raiz),
                pos=this.posOrdem(this.raiz);

        return "Pré-ordem: "+(pre.equals("")?"árvore vazia":pre)+"\n"+
                "In-ordem : "+(in .equals("")?"árvore vazia":in )+"\n"+
                "Pós-ordem: "+(pos.equals("")?"árvore vazia":pos);
    }
}
