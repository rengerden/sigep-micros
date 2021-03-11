package com.ipn.sigep.preregistro.business;



import com.ipn.sigep.preregistro.constant.Constants;
import com.ipn.sigep.preregistro.domain.Preregistros;
import com.ipn.sigep.preregistro.model.Preregistro;
import com.ipn.sigep.preregistro.repository.PreregistroRepository;
import com.ipn.sigep.preregistro.service.PreregistroService;
import com.ipn.sigep.preregistro.util.Util;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


/**
 * Clase que implementa la interface para el preregistro de alumnos.
 * 
 * @author rengerden
 * @version 1.0.0
 * 
 */
@Service

/** The Constant log. */
@Slf4j
public class PreregistroServiceImpl implements PreregistroService {

  /** The preregistro repository. */
  @Autowired
  PreregistroRepository preregistroRepository;

  /** The email sender. */
  @Autowired
  public JavaMailSender emailSender;

  /** The template engine. */
  @Autowired
  private SpringTemplateEngine templateEngine;

  /**
   * Save preregistro.
   *
   * @param preregistroModel the preregistro model
   * @throws ParseException the parse exception
   * @throws MessagingException the messaging exception
   */
  @Override
  public void savePreregistro(Preregistro preregistroModel)
      throws ParseException, MessagingException {

    preregistroRepository.save(getDomain(preregistroModel));

    try {
      log.info("Enviando correo...");
      sendMailTemplate(preregistroModel);
      log.info("correo Enviado...");
    } catch (Exception e) {
      log.error("savePreregistro", e);
    }

  }


  /**
   * Send mail template.
   *
   * @param preregistroModel the preregistro model
   * @throws MessagingException the messaging exception
   */
  public void sendMailTemplate(Preregistro preregistroModel) throws MessagingException {
    MimeMessage message = emailSender.createMimeMessage();
    final MimeMessageHelper helper =
        new MimeMessageHelper(message, true, StandardCharsets.UTF_8.name());


    final Context context = new Context();
    Map<String, Object> model = new HashMap<>();
    model.put("message", getMessage(preregistroModel.getNombre()));
    model.put("background", "background");
    model.put("logo", "logo");
    context.setVariables(model);


    helper.setTo(preregistroModel.getCorreoElectronico());
    helper.setText(templateEngine.process("mailTemplate", context), true);
    helper.setBcc("maeven.rengerden@gmail.com");
    helper.setSubject("Preregistro creado exitosamente");
    helper.setFrom("mailSIGEP@noreply.com");
    helper.addInline("logo", new ClassPathResource("static/images/ipnLogo.png"));
    helper.addInline("background", new ClassPathResource("static/images/background.jpeg"),
        "image/jpeg");


    emailSender.send(message);


  }

  /**
   * Gets the lista preregistro.
   *
   * @return the lista preregistro
   */
  @Override
  public List<Preregistros> getListaPreregistro() {
    log.debug(preregistroRepository.findAll().stream().count() + " total registros");
    return preregistroRepository.findAll();
  }

  /**
   * Update preregistro.
   *
   * @param preregistroModel the preregistro model
   * @throws ParseException the parse exception
   */
  @Override
  public void updatePreregistro(Preregistro preregistroModel) throws ParseException {
    preregistroRepository.saveAndFlush(getDomain(preregistroModel));
  }

  /**
   * Gets the preregistro.
   *
   * @param idPreregistro the id preregistro
   * @return the preregistro
   */
  @Override
  public Preregistros getPreregistro(Integer idPreregistro) {
    return preregistroRepository.getOne(idPreregistro);
  }

  /**
   * Gets the preregistro by folio.
   *
   * @param folio the folio
   * @return the preregistro by folio
   */
  @Override
  public Preregistros getPreregistroByFolio(String folio) {
    return preregistroRepository.findByFolio(folio);
  }

  /**
   * Gets the preregistro by curp.
   *
   * @param curp the curp
   * @return the preregistro by curp
   */
  @Override
  public Preregistros getPreregistroByCurp(String curp) {
    return preregistroRepository.findByCurp(curp);
  }

  /**
   * Delete preregistro by id.
   *
   * @param idPreregistro the id preregistro
   */
  @Override
  public void deletePreregistroById(Integer idPreregistro) {
    preregistroRepository.deleteById(idPreregistro);
  }

  /**
   * Delete preregistro by curp.
   *
   * @param curp the curp
   */
  @Override
  public void deletePreregistroByCurp(String curp) {
    preregistroRepository.deleteByCurp(curp);
  }

  /**
   * Delete preregistro by folio.
   *
   * @param folio the folio
   */
  @Override
  public void deletePreregistroByFolio(String folio) {
    preregistroRepository.deleteByFolio(folio);
  }

  /**
   * Gets the domain.
   *
   * @param preregistroModel the preregistro model
   * @return the domain
   * @throws ParseException the parse exception
   */
  private Preregistros getDomain(Preregistro preregistroModel) throws ParseException {
    return Preregistros.builder().nombre(preregistroModel.getNombre())
        .apellidoPaterno(preregistroModel.getApellidoPaterno())
        .apellidoMaterno(preregistroModel.getApellidoMaterno())
        .correoElectronico(preregistroModel.getCorreoElectronico()).curp(preregistroModel.getCurp())
        .genero(getGenero(preregistroModel.getCurp())).fechaCreacion(new Date())
        .fechaNacimiento(Util.parseDate(getFechaNacimiento(preregistroModel.getCurp())))
        .folio(getFolio()).idProgramaAcademico(preregistroModel.getIdProgramaAcademico())
        .estatus(Constants.VALOR_INT_1).build();
  }

  /**
   * Gets the genero.
   *
   * @param curp the curp
   * @return the genero
   */
  private String getGenero(String curp) {
    return curp.substring(Constants.VALOR_INT_10, Constants.VALOR_INT_11);
  }

  /**
   * Gets the fecha nacimiento.
   *
   * @param curp the curp
   * @return the fecha nacimiento
   */
  private String getFechaNacimiento(String curp) {
    return curp.substring(Constants.VALOR_INT_4, Constants.VALOR_INT_10);
  }

  /**
   * Gets the folio.
   *
   * @return the folio
   */
  private String getFolio() {
    return UUID.randomUUID().toString().replace("-", "").substring(Constants.VALOR_INT_0,
        Constants.VALOR_INT_16);
  }

  /**
   * Gets the message.
   *
   * @param nombre the nombre
   * @return the message
   */
  private String getMessage(String nombre) {
    return new StringBuilder().append(nombre)
        .append(" acude a las oficinas de Posgrado con el siguiente folio ")
        .append(getFolio().toUpperCase()).append(" para la asignación de tu Boleta").toString();
  }

}
