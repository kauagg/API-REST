package com.exemplo.api.service;

import com.exemplo.api.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst();
    }

    public Usuario criar(Usuario usuario) {
        usuario.setId(contadorId.getAndIncrement());
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> atualizar(Long id, Usuario usuarioAtualizado) {
        return buscarPorId(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setIdade(usuarioAtualizado.getIdade());
            return usuario;
        });
    }

    public boolean deletar(Long id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}