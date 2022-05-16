<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * Participant
 *
 * @ORM\Table(name="participant", uniqueConstraints={@ORM\UniqueConstraint(name="idEven", columns={"idEven"})}, indexes={@ORM\Index(name="fk_b", columns={"id_user"})})
 * @ORM\Entity
 */
class Participant
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_parti", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idParti;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_user", referencedColumnName="id_user")
     * })
     */
    private $idUser;

    /**
     * @var Events
     *
     * @ORM\ManyToOne(targetEntity="Events")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idEven", referencedColumnName="idEven")
     * })
     */
    private $idEven;

    public function getIdEven(): ?Events
    {
        return $this->idEven;
    }

    public function setIdEven(?Events $idEven): Events
    {
        $this->idEven = $idEven;

        return $this;
    }

    public function getIdParti(): ?int
    {
        return $this->idParti;
    }

    public function getIdUser(): ?int
    {
        return $this->idUser;
    }

    public function setIdUser(?User $idUser): ?User
    {
        $this->idUser = $idUser;

        return $idUser;
    }




    public function __toString()
    {
        return (string) $this->idParti;
    }

    /**
     * @param int $idParti
     */
    public function setIdParti(int $idParti): void
    {
        $this->idParti = $idParti;
    }


}