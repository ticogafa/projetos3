package com.example.rea4e.domain.service;
public class InteracaoService{
    
}
/*
 * Esta classe é responsável por implementar as regras de negócio relacionadas a interação do usuário com os recursos educacionais abertos. ela evita uma dependência direta entre as duas entidades. Pois antes, o service de recurso chamava o service de usuário e vice-versa. Agora, o service de interação é responsável por intermediar a interação entre as duas entidades.
 
@Service
@Transactional
public class InteracaoService {

private final UsuarioRepository usuarioRepository;
private final RecursoEducacionalAbertoService reaService;
private final UsuarioService usuarioService;
private final CursoService cursoService;

    public InteracaoService(
            UsuarioRepository usuarioRepository,
            RecursoEducacionalAbertoService reaService,
            UsuarioService usuarioService,
            CursoService cursoService) {
        this.usuarioRepository = usuarioRepository;
        this.reaService = reaService;
        this.usuarioService = usuarioService;
        this.cursoService = cursoService;
    }



    //Intermediario entre o service de usuario e o service de recurso
    public void marcarReaComoConcluido(Long usuarioId, Long recursoId) {
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);//aq vai verificar se o recurso existe
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe

        if(usuario.getReasConcluidos().contains(recurso)){
            throw new ReourceAlreadyFinishedException("Recurso já marcado como concluído.");
        }

        usuario.getReasConcluidos().add(recurso);
        usuarioRepository.save(usuario);
        
    }

    //Intermediario entre o service de usuario e o service de recurso
    public void desmarcarReaComoConcluido(Long usuarioId, Long recursoId) {
        RecursoEducacionalAberto recurso = reaService.buscarPorId(recursoId);//aq vai verificar se o recurso existe
        Usuario usuario = usuarioService.buscarPorId(usuarioId);//a função verifica se a entidade existe

        if (!usuario.getReasConcluidos().remove(recurso)) {
            throw new NoResourcesFoundException("Recurso não encontrado nos concluídos.");
        }
        usuarioRepository.save(usuario);
    }

    //Intermediario entre o service de usuario e o service de curso
    public void inscreverEmCurso(Long usuarioId, Long cursoId){
        if(usuarioId != null && cursoId != null){

            Usuario usuario = usuarioService.buscarPorId(usuarioId);
            Curso curso = cursoService.buscarPorId(cursoId);
            List<Curso> inscricoes = usuario.getCursosInscritos();
            boolean wasAdded = inscricoes.add(curso);
            if (!wasAdded) {
                throw new NoResourcesFoundException("Curso já inscrito pelo usuário com ID: " + usuario.getId());
            }
            usuarioRepository.save(usuario);
        }

    }

    //Intermediario entre o service de usuario e o service de curso
    public void desinscreverEmCurso(Long usuarioId, Long cursoId){

        if(usuarioId != null && cursoId != null){
            Usuario usuario = usuarioService.buscarPorId(usuarioId);
            Curso curso = cursoService.buscarPorId(cursoId);
            List<Curso> inscricoes = usuario.getCursosInscritos();
            boolean wasRemoved = inscricoes.remove(curso);
            if (!wasRemoved) {
                throw new NoResourcesFoundException("Curso não encontrado nos inscritos do usuário com ID: " + usuario.getId());
            }
            usuarioRepository.save(usuario);
        }
    }
    

}

*/